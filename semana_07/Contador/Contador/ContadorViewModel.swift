//
//  ContadorViewModel.swift
//  Contador
//
//  Created by Valéria Cavalcanti on 26/11/21.
//

import SwiftUI

class ContadorViewModel: ObservableObject{
    @Published var quantidade:Int = 0
    
    func add() {
        if (self.quantidade < 10){
            self.quantidade += 1
        }
    }
    
    func del(){
        if (self.quantidade > 0){
            self.quantidade -= 1
        }
    }
}
