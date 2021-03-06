package org.jctools.queues.atomic;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.jctools.queues.MessagePassingQueue;
import org.jctools.queues.MpqSanityTestMpscUnbounded;
import org.jctools.queues.MpscUnboundedArrayQueue;
import org.jctools.queues.spec.ConcurrentQueueSpec;
import org.jctools.queues.spec.Ordering;

@RunWith(Parameterized.class)
public class AtomicMpqSanityTestMpscUnbounded extends MpqSanityTestMpscUnbounded
{
    public AtomicMpqSanityTestMpscUnbounded(ConcurrentQueueSpec spec, MessagePassingQueue<Integer> queue)
    {
        super(spec, queue);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters()
    {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        list.add(makeAtomic(0, 1, 0, Ordering.FIFO, new MpscUnboundedArrayQueue<>(2)));
        list.add(makeAtomic(0, 1, 0, Ordering.FIFO, new MpscUnboundedArrayQueue<>(64)));
        return list;
    }

}
