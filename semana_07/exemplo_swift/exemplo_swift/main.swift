//
//  main.swift
//  exemplo_swift
//
//  Created by Valéria Cavalcanti on 23/11/21.
//

import Foundation

// variáveis
var nome: String = "Valéria"
var idade = 15

print(nome, type(of: nome))
print(idade, type(of: idade))

// constante
let QTDE = 10

print(QTDE, type(of: QTDE))

// variável optional
var tam:Int?

tam = 200

print(tam)
print(tam ?? -1)

if let t = tam{
    print(t)
}else{
    print("nao tem valor")
}


// extension

extension String{
    func ifpb() -> String{
        return "Instituto Federal de Educação, Ciência e Tecnologia da Paraíba"
    }
}

print(nome, type(of: nome))
print(nome.ifpb())
