package in.harshita;

import java.util.List;
import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class AppFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		HttpHeaders headers = request.getHeaders();
		Flux<DataBuffer> body = request.getBody();
		Set<String> keySet = headers.keySet();
		 keySet.forEach(key->{
			 List<String> values = headers.get(key);
			 System.out.println(key);
			 System.out.println(values);
			 System.out.println("===================");
		 });
		
	   
		return chain.filter(exchange);
	}

}
