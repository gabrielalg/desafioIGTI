var fs = require("fs");
var readline = require("readline");
var rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
var funcionarios = [
    {
        nome: "João",
        salarioBruto: 5000
    },
    {
        nome: "Carla",
        salarioBruto: 7000
    }
];

function listarFuncionarios() {
    // console.log(funcionarios.map(funcionario => funcionario.nome).join('| '))
    listaFuncionarios = funcionarios.map((funcionario, index) => `${index+1} - ${funcionario.nome}`).join('\n')
    return listaFuncionarios
}

function perguntaFuncionario() {
   
    rl.question("Qual o nome do funcionário?\n", function (nomeFuncionario) {
        if (nomeFuncionario === "" || nomeFuncionario.length < 3 ) {
            console.log("\nDigite um nome válido.\n")
            perguntaFuncionario()
        } else {
            console.log("Nome: " + nomeFuncionario)
            perguntaSalario()
            function perguntaSalario() {
                rl.question("Qual o salario bruto de " + nomeFuncionario + "?\n", function (salarioFuncionario) {
                    var salarioBruto = parseInt(salarioFuncionario);
    
                    if (Number.isNaN(salarioBruto) === true) {
                        console.log("\nDigite um salário válido.\n")
                        perguntaSalario()
                    } else {
                        console.log("Salário: " + salarioFuncionario +"\n")
                        funcionario = {
                            nome: nomeFuncionario,
                            salarioBruto: salarioBruto
                        };
                        funcionarios.push(funcionario);
                        mostrarMenu()
                    }
                });
            }
        }
    });
}

function perguntaContracheque() {
    rl.question("De quem você quer imprimir o Contracheque?\n" + listarFuncionarios() + "\n", function (indexFuncionario) {
        var index = parseInt(indexFuncionario - 1);
        // console.log(funcionarios.length - 1)
        // console.log(index)
        if (Number.isNaN(index) === true || index > funcionarios.length - 1 || index < 0) {
            console.log("\nNão existe funcionário nessa posição.\n")
            perguntaContracheque()
        } else {
            const funcionario = funcionarios[index]
            const inss = calcularINSS(funcionario)
            const irrf = calcularIRRF(funcionario, inss) 
            const salarioLiquido = funcionario.salarioBruto - inss - irrf
            console.log("\n----- HOLERITE -----")
            console.log("Funcionário(a):  " + funcionario.nome)
            console.log("Salário Bruto:   " + funcionario.salarioBruto)
            console.log("Desconto INSS:   " + inss)
            console.log("Desconto IRRF:   " + irrf)
            console.log("Salário líquido: " + salarioLiquido.toFixed(2))
            console.log("--------------------\n")
            mostrarMenu()
        }
    });
}

function calcularINSS(funcionario) {
    var salario = funcionario.salarioBruto
    var descontoINSS = 0;

    if (salario <= 1045.00) {
        descontoINSS = salario * 0.075
    } else if (salario - 1045 >= 0) {
        descontoINSS = 1045 * 0.075
    } 
    if (salario > 1045.00 && salario <= 2089.60) {
        descontoINSS += (salario - 1045.01) * 0.09
    } else if (salario - 2089.60 > 0 ) {
        descontoINSS += (2089.60 - 1045.01) * 0.09
    } 
    if (salario > 2089.61 && salario <= 3134.40) {
        descontoINSS += (salario - 2089.61) * 0.12
    } else if (salario - 3134.40 > 0) {
        descontoINSS += (3134.40 - 2089.61) * 0.12
    }
    if (salario > 3134.41 && salario <= 6101.06) {
        descontoINSS += (salario - 3134.41) * 0.14
    } else if (salario - 6101.06 > 0) {
        descontoINSS = 713.10
    }
    // console.log(descontoINSS)
    return descontoINSS.toFixed(2)
}

function calcularIRRF(funcionario, inss) {
    var salario = funcionario.salarioBruto - inss
    var irrf = 0

    if (salario > 1903.98 && salario <= 2826.65) {
        irrf = salario * 0.075 - 142.80  
    } else if (salario > 2826.65 && salario <= 3751.05) {
        irrf = salario * 0.15 - 354.80
    } else if (salario > 3751.05 && salario <= 4664.68) {
        irrf = salario * 0.225 - 636.13
    } else if (salario > 4664.68) {
        irrf = salario * 0.275 - 869.36
    }

    return irrf.toFixed(2)
}

// ------ Programa 

function mostrarMenu() {
    rl.question("O que deseja fazer? \n1 - Cadastrar Funcionário | 2 - Imprimir Contracheque | 3 - Sair\n", function (opcao) {
        switch (opcao.toLowerCase()) {
            case "1":
                perguntaFuncionario()
                break;
            case "2":
                perguntaContracheque()
                break;
            case "3":
                console.log("\nObrigado por utilizar o sistema de RH!")
                rl.close();
                break;
            default:
                console.log("\n> Por favor, digite uma opção válida.\n")
                mostrarMenu();
        }
    });
}

console.log("\nBem-vindo ao sistema do RH!\n")

mostrarMenu()
