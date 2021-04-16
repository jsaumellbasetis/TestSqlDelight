import Foundation
import shared

protocol SharedVmWrapper {
    associatedtype MyType: CoreClearable
    var vm: MyType { get }
    
    func onDisappear()
}

extension SharedVmWrapper {
    func onDisappear() {
        vm.clear()
    }
}
