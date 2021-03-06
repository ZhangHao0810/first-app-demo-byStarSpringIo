package com.zhanghao.firstappdemo.config;

import com.zhanghao.firstappdemo.domain.User;
import com.zhanghao.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * 路由器函数 配置
 */
@Configuration//表示类的对象是 配置对象（Spring 3 之后出现） 相当于这里是java版的xml文件。
public class RouterFunctionConfiguration {

    /**
     * Servlet
     *  请求接口： ServletRequest 或者 HttpServletRequest
     *  响应接口：ServletResponse 或者 HttpServletResponse
     *  Spring5.0  重新定义了服务请求和响应接口
     *  请求接口： ServerRequest
     *  响应接口：ServerResponse
     *  既可以servlet 规范，也可以支持自定义，比如 Netty（Web Server）
     *
     *  本例子：
     *      定义GET请求，并且返回所有的用户对象，URI：/person/find/all
     *      Flux 是0-N个对象集合
     *      Mono 是0-1个对象集合
     *      Reactive 中的 Flux 或者 Mono 是异步处理。（非阻塞）
     *      集合对象 基本上是 同步处理。（阻塞）
     *      Flux 或者 Mono 都是 Publisher 发布器。
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){

        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request ->{
                    //返回所有用户对象
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux,User.class);
                });
    }
}
