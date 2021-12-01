//
//  ContentView.swift
//  navegacao
//
//  Created by Valéria Cavalcanti on 30/11/21.
//

import SwiftUI

struct ContentView: View {
    @ObservedObject var navegacaoVM: NavegacaoViewModel
    
    var body: some View {
        if (self.navegacaoVM.tela == 0){
            telaPrincipal
        }else if (self.navegacaoVM.tela == 1){
            Tela01View(navegacaoVM: self.navegacaoVM)
        }else if (self.navegacaoVM.tela == 2){
            Tela02View(navegacaoVM: self.navegacaoVM)
        }else if (self.navegacaoVM.tela == 3){
            Tela03View(navegacaoVM: self.navegacaoVM)
        }else if (self.navegacaoVM.tela == 4){
            Tela04View(navegacaoVM: self.navegacaoVM)
        }
    }
}

extension ContentView{
    var telaPrincipal: some View{
        VStack{
            Group{
                Text("Navegação")
                Button("Tela 01"){
                    self.navegacaoVM.tela = 1
                }
                Button("Tela 02"){
                    self.navegacaoVM.tela = 2
                }
                Button("Tela 03"){
                    self.navegacaoVM.tela = 3
                }
                Button("Tela 04"){
                    self.navegacaoVM.tela = 4
                }
            }.padding()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(navegacaoVM: NavegacaoViewModel())
    }
}
