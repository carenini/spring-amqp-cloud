package it.cefriel.itsociety.security;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class IncomingMessageListener implements MessageListener {
    public IncomingMessageListener(){
    
        Configuration cepConfig = new Configuration();
        //TODO: define the event object
        cepConfig.addEventType("StockTick",Tick.class.getName());
        EPServiceProvider cep = EPServiceProviderManager.getProvider("ITSociety_ACL",cepConfig);
        EPRuntime cepRT = cep.getEPRuntime();

        // We register an EPL statement
        EPAdministrator cepAdm = cep.getEPAdministrator();
        
        //TODO: define the query
        EPStatement cepStatement = cepAdm.createEPL("select * from " +
                "StockTick(symbol='AAPL').win:length(2) " +
                "having avg(price) > 6.0");

        cepStatement.addListener(new CepGoodMessageListener());
    }

    public void onMessage(Message message) {
    }
}
