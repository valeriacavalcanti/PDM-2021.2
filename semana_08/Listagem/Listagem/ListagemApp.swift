//
//  ListagemApp.swift
//  Listagem
//
//  Created by Valéria Cavalcanti on 30/11/21.
//

import SwiftUI

@main
struct ListagemApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView(listagemVM: ListagemViewModel())
        }
    }
}
