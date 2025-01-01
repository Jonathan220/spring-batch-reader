package br.com.jonathan.arquivo_largura_fixa.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.jonathan.arquivo_largura_fixa.entities.Pessoa;

@Configuration
public class writerConfig {

    @Bean
    public ItemWriter<Pessoa> writer(){
        return items -> items.forEach(System.out::println);
    }
}
