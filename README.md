# SauceDemo UI Test Automation

🇺🇸 [English](#-english) | 🇧🇷 [Português](#-português)

---

## 🇺🇸 English

### About

UI test automation project for [SauceDemo](https://www.saucedemo.com/), a demo e-commerce application. Built with **Java**, **Selenium WebDriver**, **JUnit 5** and **Maven**, following the **Page Object Model (POM)** design pattern.

This project is part of my QA Automation portfolio and demonstrates clean test structure, reusable page objects and reliable element handling with explicit waits.

### Tech Stack

| Tool | Purpose |
|---|---|
| Java 17 (11+ works) | Programming language |
| Selenium WebDriver 4 | Browser automation |
| JUnit 5 | Test framework and assertions |
| Maven | Build and dependency management |
| Google Chrome | Browser under test |

### Project Structure

```
saucedemo-automation/
├── pom.xml
├── README.md
└── src/
    └── test/
        └── java/
            ├── pages/
            │   └── LoginPage.java      # Page Object for the login screen
            └── tests/
                └── LoginTest.java      # Login test scenarios
```

### Test Scenarios

| Test | Description | Expected result |
|---|---|---|
| `successfulLogin` | Login with `standard_user` and valid password | User is redirected to the products page (`inventory.html`) |
| `loginUserBlocked` | Login with `locked_out_user` | Error message: *"Sorry, this user has been locked out."* |
| `invalidPassword` | Login with valid user and wrong password | Error message: *"Username and password do not match any user in this service"* |

### Prerequisites

Make sure you have installed:

- [JDK 11 or higher](https://adoptium.net/)
- [Apache Maven 3.8+](https://maven.apache.org/download.cgi)
- [Google Chrome](https://www.google.com/chrome/) (latest version)
- Git

Check your setup:

```bash
java -version
mvn -version
```

> Selenium 4 uses **Selenium Manager** to download the correct ChromeDriver automatically. No manual driver setup is needed.

### How to Run

**1. Clone the repository**

```bash
git clone https://github.com/YOUR-USERNAME/saucedemo-automation.git
cd saucedemo-automation
```

**2. Run all tests**

```bash
mvn clean test
```

**3. Run a specific test class**

```bash
mvn test -Dtest=LoginTest
```

**4. Run a single test method**

```bash
mvn test -Dtest=LoginTest#successfulLogin
```

**Running from VS Code:** install the *Extension Pack for Java*, open `LoginTest.java` and click the green play icon next to `@Test` (do **not** use the top-right ▶ button, which looks for a `main` method).

### Headless Mode

To run without opening the browser window (useful for CI), configure `ChromeOptions` in the `setUp()` method:

```java
ChromeOptions options = new ChromeOptions();
options.addArguments("--headless=new");
driver = new ChromeDriver(options);
```

### Test Reports

After execution, Maven Surefire generates reports at:

```
target/surefire-reports/
```

### Test Data

Credentials come from the public SauceDemo page:

| Username | Password | Behavior |
|---|---|---|
| `standard_user` | `secret_sauce` | Normal login |
| `locked_out_user` | `secret_sauce` | Blocked user |

### Best Practices Applied

- Page Object Model: locators and actions live in page classes, assertions live in tests
- Explicit waits (`WebDriverWait`) instead of `Thread.sleep`
- Locator priority: `data-test` > `id` > CSS selector > XPath (only when necessary)
- Independent tests: each test opens and closes its own browser session

### Troubleshooting

| Problem | Solution |
|---|---|
| `Tests run: 0` | Class name must match `*Test.java`, and files must be in `src/test/java`. Use `maven-surefire-plugin` 3.x |
| `Main method not found` (VS Code) | Run tests with the test runner icon or `mvn test`, not the generic Run button |
| `CDP implementation` warnings | Harmless. Update `selenium-java` to the latest version in `pom.xml` |
| Browser doesn't open | Update Google Chrome and check your internet connection |

### Roadmap

- [ ] `ProductsPage`, `CartPage` and `CheckoutPage` page objects
- [ ] Full purchase flow test
- [ ] Data-driven tests with `@ParameterizedTest`
- [ ] Allure reports
- [ ] CI with GitHub Actions
- [ ] Cross-browser execution (Firefox, Edge)

### Author

**Eduardo Celestrino**
[LinkedIn](https://www.linkedin.com/in/eduardocelestrino) · [GitHub](https://github.com/EduCelestrino)

---

## 🇧🇷 Português

### Sobre

Projeto de automação de testes de UI para o [SauceDemo](https://www.saucedemo.com/), uma aplicação de e-commerce de demonstração. Desenvolvido com **Java**, **Selenium WebDriver**, **JUnit 5** e **Maven**, seguindo o padrão de projeto **Page Object Model (POM)**.

Este projeto faz parte do meu portfólio de QA e demonstra estrutura de testes organizada, page objects reutilizáveis e tratamento confiável de elementos com esperas explícitas.

### Tecnologias

| Ferramenta | Finalidade |
|---|---|
| Java 17 (11+ funciona) | Linguagem de programação |
| Selenium WebDriver 4 | Automação do navegador |
| JUnit 5 | Framework de testes e asserções |
| Maven | Build e gerenciamento de dependências |
| Google Chrome | Navegador usado nos testes |

### Estrutura do Projeto

```
saucedemo-automation/
├── pom.xml
├── README.md
└── src/
    └── test/
        └── java/
            ├── pages/
            │   └── LoginPage.java      # Page Object da tela de login
            └── tests/
                └── LoginTest.java      # Cenários de teste de login
```

### Cenários de Teste

| Teste | Descrição | Resultado esperado |
|---|---|---|
| `successfulLogin` | Login com `standard_user` e senha válida | Usuário é redirecionado para a página de produtos (`inventory.html`) |
| `loginUserBlocked` | Login com `locked_out_user` | Mensagem de erro: *"Sorry, this user has been locked out."* |
| `invalidPassword` | Login com usuário válido e senha incorreta | Mensagem de erro: *"Username and password do not match any user in this service"* |

### Pré-requisitos

Tenha instalado:

- [JDK 11 ou superior](https://adoptium.net/)
- [Apache Maven 3.8+](https://maven.apache.org/download.cgi)
- [Google Chrome](https://www.google.com/chrome/) (versão mais recente)
- Git

Verifique sua instalação:

```bash
java -version
mvn -version
```

> O Selenium 4 usa o **Selenium Manager** para baixar o ChromeDriver correto automaticamente. Não é necessário configurar o driver manualmente.

### Como Executar

**1. Clone o repositório**

```bash
git clone https://github.com/SEU-USUARIO/saucedemo-automation.git
cd saucedemo-automation
```

**2. Execute todos os testes**

```bash
mvn clean test
```

**3. Execute uma classe de teste específica**

```bash
mvn test -Dtest=LoginTest
```

**4. Execute um único método de teste**

```bash
mvn test -Dtest=LoginTest#successfulLogin
```

**Pelo VS Code:** instale a extensão *Extension Pack for Java*, abra o `LoginTest.java` e clique no ícone de play verde ao lado do `@Test` (**não** use o botão ▶ do canto superior direito, que procura um método `main`).

### Modo Headless

Para rodar sem abrir a janela do navegador (útil em CI), configure o `ChromeOptions` no método `setUp()`:

```java
ChromeOptions options = new ChromeOptions();
options.addArguments("--headless=new");
driver = new ChromeDriver(options);
```

### Relatórios de Teste

Após a execução, o Maven Surefire gera os relatórios em:

```
target/surefire-reports/
```

### Dados de Teste

As credenciais vêm da própria página pública do SauceDemo:

| Usuário | Senha | Comportamento |
|---|---|---|
| `standard_user` | `secret_sauce` | Login normal |
| `locked_out_user` | `secret_sauce` | Usuário bloqueado |

### Boas Práticas Aplicadas

- Page Object Model: localizadores e ações ficam nas páginas, asserções ficam nos testes
- Esperas explícitas (`WebDriverWait`) em vez de `Thread.sleep`
- Prioridade de localizadores: `data-test` > `id` > CSS selector > XPath (só quando necessário)
- Testes independentes: cada teste abre e fecha sua própria sessão do navegador

### Solução de Problemas

| Problema | Solução |
|---|---|
| `Tests run: 0` | O nome da classe deve seguir `*Test.java` e os arquivos devem estar em `src/test/java`. Use o `maven-surefire-plugin` 3.x |
| `Main method not found` (VS Code) | Rode os testes pelo ícone do test runner ou com `mvn test`, não pelo botão Run genérico |
| Avisos de `CDP implementation` | Inofensivos. Atualize o `selenium-java` para a versão mais recente no `pom.xml` |
| O navegador não abre | Atualize o Google Chrome e verifique sua conexão com a internet |

### Próximos Passos

- [ ] Page objects `ProductsPage`, `CartPage` e `CheckoutPage`
- [ ] Teste do fluxo completo de compra
- [ ] Testes orientados a dados com `@ParameterizedTest`
- [ ] Relatórios com Allure
- [ ] CI com GitHub Actions
- [ ] Execução em múltiplos navegadores (Firefox, Edge)

### Autor

**Eduardo Celestrino**
[LinkedIn](https://www.linkedin.com/in/eduardocelestrino) · [GitHub](https://github.com/EduCelestrino)