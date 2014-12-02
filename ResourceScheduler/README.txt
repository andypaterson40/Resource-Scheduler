The Resource Scheduler project is incomplete, i spent about two hours on the exercise but due to other commitments,
i was unable to finish it off.

I will explain what my intentions were:

Throughout this exercise i was trying to keep it simple and use a multi-threaded application along with a 
ConcurrentLinkedQueue. The reason i wanted to use this queue is that:
	- It is a first in first out queue, so the resources should be able to handle messages efficiently this way.
	- It is thread safe
	- and would work efficiently and effectively with a threaded application.
	
I was thinking of using a BlockingQueue to queue up the messages but i withdrew this option
as it is capacity bounded
	
The reason i wanted to use a multi-thread application so that each resource would be able to process messages
and not in anyway get in a deadlock situation whereby they were trying to get the same message from the queue.
I wanted to make use of all the available resources i had without running into any problems when trying to process
messages in the queue.

I started off with TDD when writing the GatewayImplTest and MessageImplTest but then wanted to proceed further with
my development and write down the message prioritization algorithm.

I tried to keep the algorithm simple (MessagePrioritisation.java) and efficient so the resources could handle the processing of
messages quickly with out any problems.
The intention was to get a message and grab the details from that message and in particular the
group id and the message id.
	- then store the current message in a local variable and then proceed to find the next message
	group ID is contained within the queue. If not proceed on with the current message.	