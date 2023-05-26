#Desafio do Coordenador 
**Coda comigo de 24/05/2023**


Neste primeiro desafio a Holding Benezinho está precisando criar etiquetas para seus produtos, porém teme que alguém possa falsificá-las.
Para evitar a falsificação uma das medidas é que seja gerado num numero com dígito verificador que possa ser validado no futuro.

Você foi contratado como Programador Java e, na sprint atual, ficou determinado que você deverá implementar o código para geração deste dígito verificador.

Você deverá:

1) Criar método capaz de gerar um número inteiro aleatório **com pelo menos três dígitos**;
   
   Supondo que o número gerado seja: **971418772**

2) Criar uma função capaz de gerar o dígito verificador para esse número gerado no passo anterior seguindo a seguinte lógica:

   1. Converter os dois últimos dígitos em números binários. 
   
       Sendo assim, os dois últimos dígitos será o número: **72** que representa **1001000** em binário.
   
   2. Deslocar duas casas para a direita do número binário, completando com zeros à esquerda. Em seguida, Converter o binário resultante novamente para o **valor decimal**. O dígito será este valor. 
      
      Portanto:
   
      O binário do número 72 é **1001000**, ao deslocar duas casas para a direita resultará em **0010010** que é igual a **18** em números decimais. **Atenção para completar com zero à esquerda para número menores que 10**


Considerando o exemplo a etiqueta será: **971418772-18**



Outras etiquetas válidas:

**324762910-02**
**143394239-09**
**609373231-07**
**55577415-03**
**999-24**
**000-00**
**111-02**
**222-05**
**123-05**





