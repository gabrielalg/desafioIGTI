## Desafio Final do Bootcamp de Programadora de Software Iniciante
Neste desafio, foi solicitado que fizéssemos um sistema para calcular o salário líquido de um funcionário baseado no seu salário bruto e descontos do INSS e IRRF. O programa foi desenvolvido nas 3 linguagens vistas durante o curso: JavaScript (Node.js), Java e Python.

Aqui o enunciado completo disponibilizado pelo IGTI:

> **Enunciado**
>
> O desafio consiste em desenvolver um sistema para controle de folha de pagamento de uma empresa, conforme os detalhes abaixo. O aluno deverá desenvolver o mesmo >sistema em cada uma das três linguagens de programação estudadas no Bootcamp, JavaScript com Node.js, Java e Python.
>
> **Atividades**
>
> O aluno deverá desenvolver um sistema para controle de folha de pagamento de funcionários de uma empresa. O programa deverá fornecer um menu de interação pelo terminal ao usuário, com as seguintes opções:
> 1) Cadastrar funcionário.
> 2) Imprimir contracheque.
> Na opção 1, o programa deverá pedir ao usuário que digite o nome e o salário bruto do funcionário. Esse funcionário deve ser armazenado em uma lista. O local de armazenamento fica a critério do aluno, podendo ser em memória ou em arquivo por exemplo.
>Na opção 2, o programa deverá perguntar ao usuário qual o índice do funcionário que ele deseja imprimir o contracheque. Lembrando que nas listas o primeiro registro corresponde ao índice 0.
>Após o usuário digitar o índice, o programa deverá realizar os cálculos abaixo para informar ao funcionário os descontos que ele terá no seu salário. Para simplificar, o programa deverá calcular somente o desconto do INSS e do IRRF, sem considerar variáveis adicionais, como por exemplo número de dependentes.
Primeiro é feito o cálculo do desconto INSS. Ele é feito de forma progressiva de acordo a faixa salarial, considerando a tabela abaixo:
>
> ![Imagem da tabela de alíquotas para o INSS](https://www12.senado.leg.br/noticias/imagens/Ttabela1.jpg)
>
> Figura 1 – Tabela INSS.
>
> Para salários acima de R$6.101,06, o desconto é fixado em R$713,10.
>
>Vamos fazer um exemplo de cálculo de desconto do INSS considerando um salário de R$5000,00:
>
> * 1ª alíquota: R$1045,00 * 7,5% = R$78,38
> * 2ª alíquota: (R$2089,60 – R$1045,01) * 9% = R$94,01
> * 3ª alíquota: (R$3134,40 – R$2089,61) * 12% = R$125,38
> * 4ª alíquota: (R$5000,00 – R$3134,41) * 14% = R$261,18
> * Desconto INSS = R$78,38 + R$94,01 + R$125,38 + R$261,18 = R$558,95
>
> O cálculo do desconto do IRRF segue a tabela da imagem abaixo. O valor utilizado para cálculo deve ser o valor do salário bruto menos o valor do desconto de INSS. Para o IRRF, o cálculo é mais simples que no INSS, pois ele não é feito de forma progressiva. Basta verificar em qual faixa o valor se encaixa, descontar a percentual alíquota e depois a parcela dedutível.
>
> ![Imagem da tabela de alíquotas para o IRRF](https://s.dicionariofinanceiro.com/imagens/tabela-irrf-cke.jpg) 
>
> Figura 2 – Tabela IRRF.
>
> Vamos fazer um exemplo considerando os mesmos R$5000,00 de salário bruto. Para verificar em qual faixa o valor se encaixa, primeiro precisamos descontar o INSS, que calculamos anteriormente, no valor de R$558,95, obtendo assim R$4441,05. Esse valor se encaixa na alíquota de 22,5%. Basta então fazer o cálculo desse percentual e, depois, descontar a parcela dedutível correspondente à faixa, que no caso é R$636,13.
>
> R$4441,05 * 22,5 = R$999,24 – R$636,13 = R$363,11
>
> Neste exemplo de salário bruto no valor de R$5000,00, o salário líquido seria então R$5000,00 – INSS (R$558,95) – IRRF (R$363,11) = R$4077,94.
>
> O programa desenvolvido deverá imprimir no terminal o contracheque do funcionário selecionado na opção 2, mostrando seu salário bruto, valor de desconto do INSS, valor de desconto do IRRF e, por fim, seu salário líquido. Segue abaixo um exemplo de saída do programa:
> * Funcionário: João
> * Salário Bruto: R$5000,00
> * Desconto INSS: R$558,95
> * Desconto IRRF: R$363,11
> * Salário Líquido: R$4077,94
>
> Segue abaixo um link como referência, que explica como fazer esses cálculos e também possui uma calculadora de salário líquido que ajuda a verificar os valores:
> https://www.todacarreira.com/calculo-salario-liquido/

