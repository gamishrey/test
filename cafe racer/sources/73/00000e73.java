package com.squareup.otto;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public class Bus {
    public static final String DEFAULT_IDENTIFIER = "default";
    private final ThreadEnforcer enforcer;
    private final ThreadLocal<ConcurrentLinkedQueue<EventWithHandler>> eventsToDispatch;
    private final Map<Class<?>, Set<Class<?>>> flattenHierarchyCache;
    private final HandlerFinder handlerFinder;
    private final ConcurrentMap<Class<?>, Set<EventHandler>> handlersByType;
    private final String identifier;
    private final ThreadLocal<Boolean> isDispatching;
    private final ConcurrentMap<Class<?>, EventProducer> producersByType;

    public Bus() {
        this(DEFAULT_IDENTIFIER);
    }

    public Bus(String str) {
        this(ThreadEnforcer.MAIN, str);
    }

    public Bus(ThreadEnforcer threadEnforcer) {
        this(threadEnforcer, DEFAULT_IDENTIFIER);
    }

    public Bus(ThreadEnforcer threadEnforcer, String str) {
        this(threadEnforcer, str, HandlerFinder.ANNOTATED);
    }

    Bus(ThreadEnforcer threadEnforcer, String str, HandlerFinder handlerFinder) {
        this.handlersByType = new ConcurrentHashMap();
        this.producersByType = new ConcurrentHashMap();
        this.eventsToDispatch = new ThreadLocal<ConcurrentLinkedQueue<EventWithHandler>>() { // from class: com.squareup.otto.Bus.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public ConcurrentLinkedQueue<EventWithHandler> initialValue() {
                return new ConcurrentLinkedQueue<>();
            }
        };
        this.isDispatching = new ThreadLocal<Boolean>() { // from class: com.squareup.otto.Bus.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public Boolean initialValue() {
                return false;
            }
        };
        this.flattenHierarchyCache = new HashMap();
        this.enforcer = threadEnforcer;
        this.identifier = str;
        this.handlerFinder = handlerFinder;
    }

    public String toString() {
        return "[Bus \"" + this.identifier + "\"]";
    }

    public void register(Object obj) {
        Set<EventHandler> handlersForEventType;
        Set<EventHandler> putIfAbsent;
        this.enforcer.enforce(this);
        Map<Class<?>, EventProducer> findAllProducers = this.handlerFinder.findAllProducers(obj);
        for (Class<?> cls : findAllProducers.keySet()) {
            EventProducer eventProducer = findAllProducers.get(cls);
            if (this.producersByType.putIfAbsent(cls, eventProducer) != null) {
                throw new IllegalArgumentException("Producer method for type " + cls + " already registered.");
            }
            Set<EventHandler> set = this.handlersByType.get(cls);
            if (set != null && !set.isEmpty()) {
                for (EventHandler eventHandler : set) {
                    dispatchProducerResultToHandler(eventHandler, eventProducer);
                }
            }
        }
        Map<Class<?>, Set<EventHandler>> findAllSubscribers = this.handlerFinder.findAllSubscribers(obj);
        for (Class<?> cls2 : findAllSubscribers.keySet()) {
            Set<EventHandler> set2 = this.handlersByType.get(cls2);
            if (set2 == null && (putIfAbsent = this.handlersByType.putIfAbsent(cls2, (set2 = new CopyOnWriteArraySet<>()))) != null) {
                set2 = putIfAbsent;
            }
            set2.addAll(findAllSubscribers.get(cls2));
        }
        for (Map.Entry<Class<?>, Set<EventHandler>> entry : findAllSubscribers.entrySet()) {
            Class<?> key = entry.getKey();
            EventProducer eventProducer2 = this.producersByType.get(key);
            if (eventProducer2 != null && (handlersForEventType = getHandlersForEventType(key)) != null) {
                for (EventHandler eventHandler2 : entry.getValue()) {
                    if (handlersForEventType.contains(eventHandler2)) {
                        dispatchProducerResultToHandler(eventHandler2, eventProducer2);
                    }
                }
            }
        }
    }

    private void dispatchProducerResultToHandler(EventHandler eventHandler, EventProducer eventProducer) {
        try {
            Object produceEvent = eventProducer.produceEvent();
            if (produceEvent == null) {
                return;
            }
            try {
                eventHandler.handleEvent(produceEvent);
            } catch (InvocationTargetException e) {
                String cls = produceEvent.getClass().toString();
                throw new RuntimeException("Could not dispatch event " + cls + " from " + eventProducer + " to handler " + eventHandler, e);
            }
        } catch (InvocationTargetException e2) {
            throw new RuntimeException("Producer " + eventProducer + " threw an exception.", e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void unregister(java.lang.Object r6) {
        /*
            r5 = this;
            com.squareup.otto.ThreadEnforcer r0 = r5.enforcer
            r0.enforce(r5)
            com.squareup.otto.HandlerFinder r0 = r5.handlerFinder
            java.util.Map r0 = r0.findAllProducers(r6)
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L13:
            boolean r1 = r0.hasNext()
            java.lang.String r2 = " registered?"
            if (r1 == 0) goto L5d
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r3 = r1.getKey()
            java.lang.Class r3 = (java.lang.Class) r3
            com.squareup.otto.EventProducer r4 = r5.getProducerForEventType(r3)
            java.lang.Object r1 = r1.getValue()
            com.squareup.otto.EventProducer r1 = (com.squareup.otto.EventProducer) r1
            if (r1 == 0) goto L3f
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L3f
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, com.squareup.otto.EventProducer> r1 = r5.producersByType
            r1.remove(r3)
            goto L13
        L3f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Missing event producer for an annotated method. Is "
            r1.append(r3)
            java.lang.Class r6 = r6.getClass()
            r1.append(r6)
            r1.append(r2)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L5d:
            com.squareup.otto.HandlerFinder r0 = r5.handlerFinder
            java.util.Map r0 = r0.findAllSubscribers(r6)
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L6b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lae
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r3 = r1.getKey()
            java.lang.Class r3 = (java.lang.Class) r3
            java.util.Set r3 = r5.getHandlersForEventType(r3)
            java.lang.Object r1 = r1.getValue()
            java.util.Collection r1 = (java.util.Collection) r1
            if (r3 == 0) goto L90
            boolean r1 = r3.removeAll(r1)
            if (r1 == 0) goto L90
            goto L6b
        L90:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Missing event handler for an annotated method. Is "
            r1.append(r3)
            java.lang.Class r6 = r6.getClass()
            r1.append(r6)
            r1.append(r2)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.otto.Bus.unregister(java.lang.Object):void");
    }

    public void post(Object obj) {
        this.enforcer.enforce(this);
        boolean z = false;
        for (Class<?> cls : flattenHierarchy(obj.getClass())) {
            Set<EventHandler> handlersForEventType = getHandlersForEventType(cls);
            if (handlersForEventType != null && !handlersForEventType.isEmpty()) {
                z = true;
                for (EventHandler eventHandler : handlersForEventType) {
                    enqueueEvent(obj, eventHandler);
                }
            }
        }
        if (!z && !(obj instanceof DeadEvent)) {
            post(new DeadEvent(this, obj));
        }
        dispatchQueuedEvents();
    }

    protected void enqueueEvent(Object obj, EventHandler eventHandler) {
        this.eventsToDispatch.get().offer(new EventWithHandler(obj, eventHandler));
    }

    protected void dispatchQueuedEvents() {
        if (this.isDispatching.get().booleanValue()) {
            return;
        }
        this.isDispatching.set(true);
        while (true) {
            try {
                EventWithHandler poll = this.eventsToDispatch.get().poll();
                if (poll == null) {
                    return;
                }
                dispatch(poll.event, poll.handler);
            } finally {
                this.isDispatching.set(false);
            }
        }
    }

    protected void dispatch(Object obj, EventHandler eventHandler) {
        try {
            eventHandler.handleEvent(obj);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Could not dispatch event: " + obj.getClass() + " to handler " + eventHandler, e);
        }
    }

    EventProducer getProducerForEventType(Class<?> cls) {
        return this.producersByType.get(cls);
    }

    Set<EventHandler> getHandlersForEventType(Class<?> cls) {
        return this.handlersByType.get(cls);
    }

    Set<Class<?>> flattenHierarchy(Class<?> cls) {
        Set<Class<?>> set = this.flattenHierarchyCache.get(cls);
        if (set == null) {
            Set<Class<?>> classesFor = getClassesFor(cls);
            this.flattenHierarchyCache.put(cls, classesFor);
            return classesFor;
        }
        return set;
    }

    private Set<Class<?>> getClassesFor(Class<?> cls) {
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        linkedList.add(cls);
        while (!linkedList.isEmpty()) {
            Class cls2 = (Class) linkedList.remove(0);
            hashSet.add(cls2);
            Class superclass = cls2.getSuperclass();
            if (superclass != null) {
                linkedList.add(superclass);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class EventWithHandler {
        final Object event;
        final EventHandler handler;

        public EventWithHandler(Object obj, EventHandler eventHandler) {
            this.event = obj;
            this.handler = eventHandler;
        }
    }
}