//
//  ListagemViewModel.swift
//  Listagem
//
//  Created by Valéria Cavalcanti on 30/11/21.
//

import SwiftUI

class ListagemViewModel: ObservableObject{
    @Published var lista: [Pessoa]
    
    init(){
        self.lista = []
    }
    
    func add(pessoa: Pessoa) {
        pessoa.id = self.lista.count + 1
        self.lista.append(pessoa)
    }
}
