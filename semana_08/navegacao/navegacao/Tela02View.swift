//
//  Tela02.swift
//  navegacao
//
//  Created by Valéria Cavalcanti on 30/11/21.
//

import SwiftUI

struct Tela02View: View {
    @ObservedObject var navegacaoVM: NavegacaoViewModel
    
    var body: some View {
        Text("Tela 02")
            .frame(maxWidth: .infinity)
            .frame(maxHeight: .infinity)
            .font(.title)
            .background(Color.red)
            .onTapGesture {
                self.navegacaoVM.tela = 0
            }
    }
}

struct Tela02View_Previews: PreviewProvider {
    static var previews: some View {
        Tela02View(navegacaoVM: NavegacaoViewModel())
    }
}
