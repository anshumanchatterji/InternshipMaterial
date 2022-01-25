package com.webservice.okhttp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.rahul.log.Logger;

import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

public class PrintingEventListener extends EventListener {

	public static final Factory FACTORY = new Factory() {
		final AtomicLong nextCallId = new AtomicLong(1L);

		@Override
		public EventListener create(Call call) {
			long callId = nextCallId.getAndIncrement();
			System.out.printf("%04d %s%n", callId, call.request().url());
			return new PrintingEventListener(callId, System.nanoTime());
		}
	};

	final long callId;
	final long callStartNanos;

	
	public PrintingEventListener(long callId, long callStartNanos) {
		this.callId = callId;
		this.callStartNanos = callStartNanos;
	}

	private void printEvent(String msg) {
		Logger.log(msg);
	}

	@Override
	public void callStart(Call call) {
		printEvent("callStart");
	}

	@Override
	public void callEnd(Call call) {
		printEvent("callEnd");
	}

	@Override
	public void secureConnectStart(Call call) {
		printEvent("sercureConnectStart");
	}

	@Override
	public void secureConnectEnd(Call call, Handshake handshake) {
		printEvent("sercureConnectEnd");
	}

	@Override
	public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
		printEvent("DNS End");
	}

	@Override
	public void dnsStart(Call call, String domainName) {
		printEvent("DNS Start");
	}

	@Override
	public void connectionAcquired(Call call, Connection connection) {
		printEvent("Connection Acquired");
	}

	@Override
	public void cacheConditionalHit(Call call, Response cachedResponse) {
		printEvent("cacheConditionalHit");
	}

	@Override
	public void callFailed(Call call, IOException ioe) {
		printEvent("callFailed");
	}

	@Override
	public void canceled(Call call) {
		printEvent("cancelled");
	}

	@Override
	public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
		printEvent("Connect End");
	}

	@Override
	public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
		printEvent("connectFailed");

	}

	@Override
	public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
		printEvent("ConnectStart");
	}

	@Override
	public void proxySelectEnd(Call call, HttpUrl url, List<Proxy> proxies) {
		printEvent("proxySelectEnd");
	}

	@Override
	public void proxySelectStart(Call call, HttpUrl url) {
		printEvent("proxySelectEnd");
	}

	@Override
	public void requestBodyEnd(Call call, long byteCount) {
		printEvent("requestBodyEnd");
	}

	@Override
	public void requestBodyStart(Call call) {
		printEvent("requestBodyStart");
	}

	@Override
	public void requestFailed(Call call, IOException ioe) {
		printEvent("requestFailed");
	}

	@Override
	public void requestHeadersEnd(Call call, Request request) {
		printEvent("requestHeadersEnd");
	}

	@Override
	public void requestHeadersStart(Call call) {
		printEvent("requestHeadersStart");
	}

	@Override
	public void responseBodyEnd(Call call, long byteCount) {
		printEvent("responseBodyEnd");
	}

	@Override
	public void responseBodyStart(Call call) {
		printEvent("responseBodyStart");
	}

	@Override
	public void responseFailed(Call call, IOException ioe) {
		printEvent("response Failed");
	}

	@Override
	public void responseHeadersEnd(Call call, Response response) {
		printEvent("response Headers End");
	}

	@Override
	public void responseHeadersStart(Call call) {
		printEvent("Response Headers Start");
	}

	@Override
	public void satisfactionFailure(Call call, Response response) {
		printEvent("SatisfactionFailure");
	}

	@Override
	public void connectionReleased(Call call, Connection connection) {
		printEvent("Connection Released");
	}

	@Override
	public void cacheMiss(Call call) {
		printEvent("cache Miss");
	}

	@Override
	public void cacheHit(Call call, Response response) {
		printEvent("cacheHit");
	}

}
