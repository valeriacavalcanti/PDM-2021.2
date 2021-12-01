//
//  ContentView.swift
//  NavigationView
//
//  Created by Valéria Cavalcanti on 30/11/21.
//

import SwiftUI

struct ContentView: View {
    @State var showForm:Bool = false
    
    var body: some View {
        NavigationView{
            VStack{
                Form{
                    Section(header: Text("Dados Pessoais")) {
                        NavigationLink("Formulário", destination: FormView(), isActive: $showForm)
                        Button("Formulário"){
                            self.showForm = true
                        }
                    }
                }
            }
            .navigationTitle("Principal")
            .navigationBarHidden(false)
            .navigationBarTitleDisplayMode(.automatic)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
