package cn.liuminhua.swagger.resteasy;

import cn.liuminhua.swagger.resteasy.rest.Api;
import io.swagger.jaxrs.config.BeanConfig;
import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

import javax.ws.rs.core.Application;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 敏华 on 2017-06-06.
 */
public class Main extends Application {

    private static int port = 8100;

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }


    private void start() {

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8100");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("io.swagger.resources");
        beanConfig.setScan(true);


        ResteasyDeployment deployment = new ResteasyDeployment();
        List<String> resourceClasses = new ArrayList<String>();
        resourceClasses.add(Api.class.getName());
        resourceClasses.add(io.swagger.jaxrs.listing.ApiListingResource.class.getName());
        deployment.setResourceClasses(resourceClasses);

        List<String> providerClasses = new ArrayList<String>();
//        providerClasses.add(DefaultTextPlain.class.getName());
//        providerClasses.add(ByteArrayProvider.class.getName());
//        providerClasses.add(InputStreamProvider.class.getName());
//        providerClasses.add(StringTextStar.class.getName());
//        providerClasses.add(FormUrlEncodedProvider.class.getName());
//        providerClasses.add(StreamingOutputProvider.class.getName());
        providerClasses.add(io.swagger.jaxrs.listing.SwaggerSerializers.class.getName());
        deployment.setProviderClasses(providerClasses);
        startNetty(deployment);
    }

    public static void startNetty(ResteasyDeployment deployment) {

        NettyJaxrsServer netty = new NettyJaxrsServer();
        netty.setDeployment(deployment);
        netty.setPort(port);
        netty.setRootResourcePath("/");
        netty.setSecurityDomain(null);
        netty.setSSLContext(null);
        netty.start();

    }


}
