//
//  Tela01.swift
//  navegacao
//
//  Created by Valéria Cavalcanti on 30/11/21.
//

import SwiftUI

struct Tela01View: View {
    @ObservedObject var navegacaoVM: NavegacaoViewModel
    
    var body: some View {
        Text("Tela 01")
            .frame(maxWidth: .infinity)
            .frame(maxHeight: .infinity)
            .font(.title)
            .background(Color.blue)
            .onTapGesture {
                self.navegacaoVM.tela = 0
            }
    }
}

struct Tela01View_Previews: PreviewProvider {
    static var previews: some View {
        Tela01View(navegacaoVM: NavegacaoViewModel())
    }
}
