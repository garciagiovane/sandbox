package com.garciagiovane.cloud.configuracao;
import com.garciagiovane.cloud.calculadora.Calculadora;
import com.garciagiovane.cloud.operacoes.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.garciagiovane.cloud")
public class ConfiguracaoCalculadora {

    @Bean
    public Calculadora calculadora(ApplicationContext ac) {
        return new Calculadora(ac);
    }

    @Bean(name="+")
    @Scope("prototype")
    public Operacao somar(@Value("${a}") double a, @Value("${b}") double b) {
        return new Soma(a, b);
    }

    @Bean(name="-")
    @Scope("prototype")
    public Subtracao subtracao (@Value("${a}") double a, @Value("${b}") double b){
        return new Subtracao(a, b);
    }

    @Bean(name="^")
    @Scope("prototype")
    public Potenciacao potenciacao (@Value("${a}") double a, @Value("${b}") double b){
        return new Potenciacao(a, b);
    }

    @Bean(name="/")
    @Scope("prototype")
    public Divisao divisao (@Value("${a}") double a, @Value("${b}") double b){
        return new Divisao(a, b);
    }

    @Bean(name="*")
    @Scope("prototype")
    public Multiplicacao multiplicacao (@Value("${a}") double a, @Value("${b}") double b){
        return new Multiplicacao(a, b);
    }
}
