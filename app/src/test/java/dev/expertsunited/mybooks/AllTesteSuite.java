package dev.expertsunited.mybooks;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import dev.expertsunited.mybooks.daoTeste.LivroDAOTest;
import dev.expertsunited.mybooks.daoTeste.UsuarioDAOTest;
import dev.expertsunited.mybooks.negocioTest.LivroTest;
import dev.expertsunited.mybooks.negocioTest.UsuarioTeste;

@RunWith(Suite.class)
@Suite.SuiteClasses({LivroTest.class, UsuarioTeste.class, UsuarioDAOTest.class, LivroDAOTest.class})
public class AllTesteSuite {
}
