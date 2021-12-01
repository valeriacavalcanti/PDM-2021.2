//
//  navegacaoApp.swift
//  navegacao
//
//  Created by Valéria Cavalcanti on 30/11/21.
//

import SwiftUI

@main
struct navegacaoApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView(navegacaoVM: NavegacaoViewModel())
        }
    }
}
