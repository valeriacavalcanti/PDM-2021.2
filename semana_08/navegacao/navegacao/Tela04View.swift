//
//  Tela04View.swift
//  navegacao
//
//  Created by Valéria Cavalcanti on 30/11/21.
//

import SwiftUI

struct Tela04View: View {
    @ObservedObject var navegacaoVM: NavegacaoViewModel
    
    var body: some View {
        Text("Tela 04")
            .frame(maxWidth: .infinity)
            .frame(maxHeight: .infinity)
            .font(.title)
            .background(Color.green)
            .onTapGesture {
                self.navegacaoVM.tela = 0
            }
    }
}

struct Tela04View_Previews: PreviewProvider {
    static var previews: some View {
        Tela04View(navegacaoVM: NavegacaoViewModel())
    }
}
