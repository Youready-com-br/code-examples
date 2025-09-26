import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.ArchRule
import spock.lang.Specification

/**
 * Utilizando Spock Framework e ArchUnit.
 * Exemplo simplificado de documentação executável
 */
class PatientModelDesignEncapsulationTest extends Specification {

    final String packageName = "br.com.youready.pap.patient.model"
    JavaClasses importedClasses;

    def setup() {
        importedClasses = new ClassFileImporter().withImportOption(DO_NOT_INCLUDE_TESTS)
                                                 .importPackages(packageName)
    }

    /**
     * Neste teste definimos a classe responsável por apresentar a API do pacote
     */
    def "Patient is the entity (or API) of the model. The reason for this is bla."() {
        when:
        ArchRule rule = ArchRuleDefinition.classes()
                                          .that()
                                          .haveSimpleName(Patient.simpleName)
                                          .should()
                                          .bePublic()

        then:
        rule.check(importedClasses)
    }

    def "All other classes must be package protected. Please hide the implementation details"() {
        when:
        ArchRule rule = ArchRuleDefinition.classes()
                .that()
                .doNotHaveSimpleName(Patient.simpleName)
                .should()
                .bePackagePrivate()

        then:
        rule.check(importedClasses)
    }
}
