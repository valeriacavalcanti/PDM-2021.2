//
//  ContentView.swift
//  Banco
//
//  Created by Valéria Cavalcanti on 30/11/21.
//

import SwiftUI
import CoreData

struct ContentView: View {
    @Environment(\.managedObjectContext) private var viewContext
    
    @FetchRequest(
        sortDescriptors: [NSSortDescriptor(keyPath: \Pessoa.nome, ascending: true)], animation: .default
    )
    var pessoas: FetchedResults<Pessoa>
    
    var body: some View {
        VStack{
            HStack{
                Button("ADD"){
                    let pessoa = Pessoa(context: self.viewContext)
                    pessoa.nome = "Teste \(self.pessoas.count + 1)"
                    do{
                        try self.viewContext.save()
                    }catch{
                        print("erro")
                    }
                }
                Button("DEL"){
                    if (self.pessoas.count > 0){
                        do{
                            self.viewContext.delete(pessoas[0])
                            try self.viewContext.save()
                        }catch{
                            print("erro")
                        }
                    }
                }
                Button("UPDATE"){
                    self.pessoas.forEach { pessoa in
                        pessoa.nome = "\(pessoa.nome!) - Alterado"
                    }
                    do{
                        try self.viewContext.save()
                    }catch{
                        print("erro")
                    }
                }
            }
            List(self.pessoas){ pessoa in
                Text(pessoa.nome!)
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
