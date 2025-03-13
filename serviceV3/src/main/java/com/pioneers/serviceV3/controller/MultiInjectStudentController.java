package com.pioneers.serviceV3.controller;

//@Lazy
//@RestController
//@RequestMapping("/multiInjectStudent")
public class MultiInjectStudentController {

    /*private final List<StudentRepository> studentRepositoryList;

    @Autowired
    public MultiInjectStudentController(List<StudentRepository> studentRepositoryList) {
        System.out.println("Creating " + this.getClass().getSimpleName()
                + " constructor!! (bean) with injecting studentRepositoryList with size: "
                + studentRepositoryList.size());
        studentRepositoryList
                .forEach(studentRepository ->
                        System.out.println("Injected bean from class named: ["
                                + studentRepository.getClass().getSimpleName()
                                + "] in controller: " + this.getClass().getSimpleName())
                );
        this.studentRepositoryList = studentRepositoryList;
    }

    @PostMapping("save")
    public void saveStudentApi(@RequestBody StudentDto studentDto) {
        studentRepositoryList.get(0).save(studentDto);
    }

    @GetMapping("findAll")
    public List<StudentDto> getStudentApi() {
        System.out.println("This is a proof for injecting the bean of class: "
                + studentRepositoryList.get(0).getClass().getSimpleName());
        return studentRepositoryList.get(0).findAll();
    }

    @GetMapping("findById/{id}")
    public StudentDto getStudentByIdApi(@PathVariable String id) {
        return studentRepositoryList.get(0).findById(id);
    }

    @PutMapping("update")
    public void updateStudentApi(@RequestParam String id, @RequestBody StudentDto newStudentDto) {
        studentRepositoryList.get(0).update(id, newStudentDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudentApi(@PathVariable String id) {
        studentRepositoryList.get(0).removeById(id);
    }

    @GetMapping("findFirst")
    public StudentDto getFirstStudentApi() {
        return studentRepositoryList.get(0).findFirst();
    }*/

}
