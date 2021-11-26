//
//  ContentView.swift
//  Contador
//
//  Created by Valéria Cavalcanti on 26/11/21.
//

import SwiftUI

struct ContentView: View {
    @ObservedObject var contadorVM: ContadorViewModel
    
    var body: some View {
        tela2
    }
}


extension ContentView{
    var tela2: some View{
        Stepper(value: self.$contadorVM.quantidade, in: 0...10) {
            Label("Pessoas (\(self.contadorVM.quantidade))", systemImage: "person.fill")
                .font(.title)
        }
    }
}


extension ContentView{
    var tela1: some View{
        VStack {
            contador
            HStack{
                btAdd
                btDel
            }
        }
    }
}

extension ContentView{
    var contador: some View{
        Text(self.contadorVM.quantidade.description)
            .font(.title)
            .padding()
    }
}

extension ContentView{
    var btAdd: some View{
        Button(action: {
            self.contadorVM.add()
        }) {
            Text("+")
                .font(.title)
                .padding()
        }
    }
}

extension ContentView{
    var btDel: some View{
        Button(action: {
            self.contadorVM.del()
        }) {
            Text("-")
                .font(.title)
                .padding()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(contadorVM: ContadorViewModel())
    }
}
