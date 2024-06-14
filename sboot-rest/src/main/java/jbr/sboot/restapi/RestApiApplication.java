package jbr.sboot.restapi;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class RestApiApplication {

    @Value("${cors.domain}")
    private String corsDomain;

    @Value("${cors.headers}")
    private String corsHeaders;

    @Value("${cors.methods}")
    private String corsMethods;

    @Value("${spring.data.rest.base-path}")
    private String basePath;

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() throws Exception {

        this.showTables();
        log.info("corsDomain: {}", corsDomain);
        log.info("corsHeaders: {}", corsHeaders);
        log.info("corsMethods: {}", corsMethods);
        log.info("basePath: {}", basePath);

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping(basePath + "/**").allowedOrigins(corsDomain.split(","))
                        .allowedHeaders(corsHeaders.split(",")).allowedMethods(corsMethods.split(",")).maxAge(3600);
            }
        };
    }

    public void showTables() throws Exception {
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        System.out.println("Schema: " + dataSource.getConnection().getSchema());
        System.out.println("Url: " + metaData.getURL());
        System.out.println("Username: " + metaData.getUserName());
        ResultSet tables = metaData.getTables(null, null, null, new String[] { "TABLE" });

        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            System.out.println(tableName);
            ResultSet columns = metaData.getColumns(null, null, tableName, null);

            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                System.out.println("\t" + columnName);
            }
        }
    }
}
