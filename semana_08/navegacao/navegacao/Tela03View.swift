//
//  Tela03view.swift
//  navegacao
//
//  Created by Valéria Cavalcanti on 30/11/21.
//

import SwiftUI

struct Tela03View: View {
    @ObservedObject var navegacaoVM: NavegacaoViewModel
    
    var body: some View {
        Text("Tela 03")
            .frame(maxWidth: .infinity)
            .frame(maxHeight: .infinity)
            .font(.title)
            .background(Color.orange)
            .onTapGesture {
                self.navegacaoVM.tela = 0
            }
    }
}

struct Tela03View_Previews: PreviewProvider {
    static var previews: some View {
        Tela03View(navegacaoVM: NavegacaoViewModel())
    }
}
