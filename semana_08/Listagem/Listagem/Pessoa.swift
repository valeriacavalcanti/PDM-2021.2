//
//  Pessoa.swift
//  Listagem
//
//  Created by Valéria Cavalcanti on 30/11/21.
//

import Foundation

class Pessoa: NSObject, Identifiable{
    var id: Int
    var nome: String
    
    override var description: String{
        return "\(id) - \(nome)"
    }
    
    init(nome: String){
        self.id = -1
        self.nome = nome
    }
}
