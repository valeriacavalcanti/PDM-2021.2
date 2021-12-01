//
//  FormView.swift
//  NavigationView
//
//  Created by Valéria Cavalcanti on 30/11/21.
//

import SwiftUI

struct FormView: View {
    @Environment(\.presentationMode) var presentationMode
    
    var body: some View {
        VStack{
            Group{
                Text("Formulário")
                    .font(.title)
                Button("Voltar via código"){
                    self.presentationMode.wrappedValue.dismiss()
                }
            }.padding()
        }
        .navigationTitle("Formulário")
        .navigationBarTitleDisplayMode(.inline)
    }
}

struct FormView_Previews: PreviewProvider {
    static var previews: some View {
        FormView()
    }
}
