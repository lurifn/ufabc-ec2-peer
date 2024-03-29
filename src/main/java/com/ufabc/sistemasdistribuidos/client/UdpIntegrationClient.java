package com.ufabc.sistemasdistribuidos.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class UdpIntegrationClient implements UdpClient {

	private final static Logger LOGGER = LoggerFactory.getLogger(UdpIntegrationClient.class);

	private final UnicastSendingMessageHandler udpSendingAdapter;

	@Autowired
	public UdpIntegrationClient(UnicastSendingMessageHandler udpSendingAdapter) {
		this.udpSendingAdapter = udpSendingAdapter;
	}

	public void sendMessage(String message) {
		LOGGER.info("Enviando UDP integrado: {} para host = " + udpSendingAdapter.getHost() + " e porta = "
				+ udpSendingAdapter.getPort(), message);
		udpSendingAdapter.handleMessage(MessageBuilder.withPayload(message).build());
		
		//udpSendingAdapter.run();
	}
}
