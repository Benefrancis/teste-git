#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dominio.pessoa.entity;

import lombok.*;

import java.time.LocalDate;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Pessoa {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private LocalDate nascimento;

//    @Override
//    public int compareTo(Pessoa o) {
//        return (int) (this.getId() - o.getId());
//    }


}
