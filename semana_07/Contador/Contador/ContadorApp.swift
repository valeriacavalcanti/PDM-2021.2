//
//  ContadorApp.swift
//  Contador
//
//  Created by Valéria Cavalcanti on 26/11/21.
//

import SwiftUI

@main
struct ContadorApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView(contadorVM: ContadorViewModel())
        }
    }
}
