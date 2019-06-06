package dev.expertsunited.mybooks;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import dev.expertsunited.mybooks.testeIntegracao.LivroIntegracaoTest;
import dev.expertsunited.mybooks.testeIntegracao.UsuarioIntegracaoTest;
import dev.expertsunited.mybooks.negocioTest.LivroTest;
import dev.expertsunited.mybooks.negocioTest.UsuarioTeste;

@RunWith(Suite.class)
@Suite.SuiteClasses({LivroTest.class, UsuarioTeste.class, UsuarioIntegracaoTest.class, LivroIntegracaoTest.class})
public class AllTesteSuite {
}
