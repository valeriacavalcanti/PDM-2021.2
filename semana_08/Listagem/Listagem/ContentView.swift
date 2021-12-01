//
//  ContentView.swift
//  Listagem
//
//  Created by Valéria Cavalcanti on 30/11/21.
//

import SwiftUI

struct ContentView: View {
    @State var nome: String = ""
    @ObservedObject var listagemVM: ListagemViewModel
    
    var body: some View {
        VStack{
            HStack{
                TextField("Nome", text: self.$nome)
                Button {
                    self.listagemVM.add(pessoa: Pessoa(nome: self.nome))
                } label: {
                    Label("", systemImage: "plus")
                }
                
            }
            List(self.listagemVM.lista){ pessoa in
                Text(pessoa.description)
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(listagemVM: ListagemViewModel())
    }
}
