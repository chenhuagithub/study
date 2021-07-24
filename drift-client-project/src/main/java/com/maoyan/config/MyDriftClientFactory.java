package com.maoyan.config;

import io.airlift.drift.client.DriftClientFactory;
import io.airlift.drift.client.address.AddressSelector;
import io.airlift.drift.client.address.SimpleAddressSelector;
import io.airlift.drift.client.address.SimpleAddressSelectorConfig;
import io.airlift.drift.codec.ThriftCodecManager;
import io.airlift.drift.transport.netty.client.DriftNettyClientConfig;
import io.airlift.drift.transport.netty.client.DriftNettyMethodInvokerFactory;

/**
 * @author chenhua11
 * @date 2021/6/27  9:48 上午
 */
public class MyDriftClientFactory {
    
    private static final String ADDRESS = "localhost:8080";
    
    private static DriftClientFactory CLIENT_FACTORY = null;
    
    static {
        SimpleAddressSelectorConfig addresses = new SimpleAddressSelectorConfig();
        addresses.setAddresses(ADDRESS);
        // expensive services that should only be created once
        ThriftCodecManager codecManager = new ThriftCodecManager();
        AddressSelector addressSelector = new SimpleAddressSelector(addresses);
        DriftNettyClientConfig config = new DriftNettyClientConfig();

        // methodInvokerFactory must be closed
        DriftNettyMethodInvokerFactory<?> methodInvokerFactory = DriftNettyMethodInvokerFactory
                .createStaticDriftNettyMethodInvokerFactory(config);

        // client factory
        CLIENT_FACTORY = new DriftClientFactory(codecManager, methodInvokerFactory, addressSelector);
    }
    
    
   
    public MyDriftClientFactory() {
    
    }
    
}