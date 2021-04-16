import shared

class ExampleVMiOS: SharedVmWrapper, ObservableObject {
    @Published var data: String = ""
    var vm: ExampleExampleViewModel
    
    init(vm: ExampleExampleViewModel) {
        self.vm = vm
        
        vm.subscribe(flow: vm.data) { newData in
            self.data = newData as! String
        }
    }
}
