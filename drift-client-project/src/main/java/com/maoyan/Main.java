package com.maoyan;

import com.maoyan.service.Caculator;
import io.airlift.drift.client.DriftClient;
import io.airlift.drift.client.DriftClientFactory;
import io.airlift.drift.client.address.AddressSelector;
import io.airlift.drift.client.address.SimpleAddressSelector;
import io.airlift.drift.client.address.SimpleAddressSelectorConfig;
import io.airlift.drift.codec.ThriftCodecManager;
import io.airlift.drift.transport.netty.client.DriftNettyClientConfig;
import io.airlift.drift.transport.netty.client.DriftNettyMethodInvokerFactory;

/**
 * @author chenhua11
 * @date 2021/6/26  8:15 下午
 */
public class Main {
    public static void main(String[] args) {
// server address
//        List<HostAndPort> addresses = ImmutableList.of(HostAndPort.fromParts("localhost", 8080));
        SimpleAddressSelectorConfig addresses = new SimpleAddressSelectorConfig();
        addresses.setAddresses("localhost:8080");
// expensive services that should only be created once
        ThriftCodecManager codecManager = new ThriftCodecManager();
        AddressSelector addressSelector = new SimpleAddressSelector(addresses);
        DriftNettyClientConfig config = new DriftNettyClientConfig();

// methodInvokerFactory must be closed
        DriftNettyMethodInvokerFactory<?> methodInvokerFactory = DriftNettyMethodInvokerFactory
                .createStaticDriftNettyMethodInvokerFactory(config);

// client factory
        DriftClientFactory clientFactory = new DriftClientFactory(codecManager, methodInvokerFactory, addressSelector);
    
        DriftClient<Caculator> driftClient = clientFactory.createDriftClient(Caculator.class);
        Caculator caculator = driftClient.get();
        int result = caculator.add(3, 4);
        System.out.println(result);
        int div = caculator.div(5, 6);
        System.out.println(div);
    }
}