package br.com.jonathan.arquivo_largura_fixa.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import br.com.jonathan.arquivo_largura_fixa.entities.Pessoa;

@Configuration
public class readerConfig {

    @Value("${spring.batch.endereco}")
    private String endereco;

    @Bean
    public ItemReader<Pessoa> leiturarArquivoLarguraFixa(){
        return new FlatFileItemReaderBuilder<Pessoa>()
        .name("leituraArquivoLarguraFixa")
        .resource(new FileSystemResource(endereco))
        .fixedLength()
        .columns(new Range[] {new Range(1, 20), new Range(21, 40), new Range(41, 45), new Range(46, 85)})
        .names(new String[] {"nome", "sobrenome", "idade", "email"})
        .targetType(Pessoa.class)
        .build();
    }
}
