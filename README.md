# aplicar_DV
Uma aplicação simples em Java que insere um digito verificador e valida matrículas baseado em dois arquivos de entrada.

Por Leonardo de Figueiredo Meliande
18 de Agosto de 2018 - 16:50

O solução pedida foi feita na linguagem Java. Utilizei a classe principal para funcionar como um menu, onde o usuário pode selecionar cada opção separadamente (a de aplicar o digito verificador, e a de verificar as matrículas), desta forma dando mais controle para o mesmo. Criei duas classes separadas para cada solução, com o objetivo de deixar o programa mais organizado.

O programa funciona de forma simples: caso o usuário selecione a primeira opção do menu principal, o programa irá instanciar a classe aplicarDV() e chamar o método de leitura do arquivo TXT "matriculas_sem_dv". O método irá ler o arquivo linha por linha, e em cada passagem ele chama outro método na mesma classe que irá realizar as operações para calcular o digito verificador, retornando seu valor e imprimindo em tempo real no arquivo de saída "matriculas_com_dv" junto com a matrícula original.

Na classe aplicarDV(), assim como na classe validarMatriculas(), foram criados dois métodos: um de leitura e escrita nos arquivos TXT, e outro para realizar as operações matemáticas etc. Novamente, para deixar o código mais organizado e de melhor compreendimento.

Caso seja selecionada a segunda opção no menu, por outro lado, é instanciada a classe validarMatriculas(). Esta classe tem a mesma estrutura que a classe aplicarDV(); no entanto, as matrículas lidas precisam ser separadas do seu digito verificador (sendo este armazenado numa variável para verificação). É realizado o cálculo matemático e verifica-se se os dois valores batem. Caso sim, o método (criado com tipo primitivo boolean) retorna "true", e é imprimido a matrícula junto com essa informação no arquivo de saída "matriculas_validadas". Caso os valores não batam, retorna "false".
