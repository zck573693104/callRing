package com.callRing.activeMq.queeue;

import javax.jms.Destination;

public interface ConsumerService {
   void receive(Destination queueDestination);
}
