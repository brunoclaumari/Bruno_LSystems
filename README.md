# Bruno_LSystems
Programa para criar linhas 2D com gramaticas tipo LSystems para fractais

Trabalho da Disciplina de Compiladores - EC6 - Profº Daniel Carvalho


-Rodar no NetBeans
Informações da IDE NetBeans

Product Version: NetBeans IDE 8.2 (Build 201609300101)
Atualizações: O IDE NetBeans está atualizado para a versão NetBeans 8.2 Patch 2

Java: 1.8.0_241; Java HotSpot(TM) 64-Bit Server VM 25.241-b07
Runtime: Java(TM) SE Runtime Environment 1.8.0_241-b07


Importante que o arquivo tem que ser nesse padrão de entrada:(Exemplo de padrão ficticio ) 

g : F, +, -,f----------------------------------ALFABETO TEM QUE SER ESSE SENÃO DÁ PROBLEMA
n : 2    --------------------------------------numero de iterações
i : F-F-F-F  ----------------------------------geração inicial (n=0)
a : 90º----------------------------------------angulo de rotação
p1 : F = F - F + F + FF - F - F + F -----------regras de produção, de 1 até n
p2 : f = F - F + F + FF - F - F + F
pn : F = F - F + F + FF - F - F + F
