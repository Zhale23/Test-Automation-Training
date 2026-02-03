import { USERS, URLS, ERROR_MESSAGES } from '../data/testData';
import LoginPage from '../pages/LoginPage';

fixture `Flujo de Autenticación`
    .page(URLS.BASE);

test('Debería loguearse exitosamente con usuario estándar', async t => {
    await LoginPage.login(USERS.STANDARD.username, USERS.STANDARD.password);

    const url = await t.eval(() => window.location.href);
    await t.expect(url).contains('/inventory.html');
});

test('Debería mostrar error con credenciales inválidas', async t => {
    await LoginPage.login(USERS.INVALID.username, USERS.INVALID.password);

    await t
        .expect(LoginPage.errorMessage.exists).ok()
        .expect(LoginPage.errorMessage.innerText).contains(ERROR_MESSAGES.INVALID_CREDENTIALS);
});

test('Debería mostrar error al intentar loguearse con usuario bloqueado', async t => {
    await LoginPage.login(USERS.LOCKED.username, USERS.LOCKED.password);
    await t
        .expect(LoginPage.errorMessage.exists).ok()
        .expect(LoginPage.errorMessage.innerText).contains(ERROR_MESSAGES.LOCKED_OUT);
});

test('Deeberia mostrar error al intentar loguearse sin credenciales', async t=>{
    await LoginPage.clickLogin();
    await t
        .expect(LoginPage.errorMessage.exists).ok()
        .expect(LoginPage.errorMessage.innerText).contains(ERROR_MESSAGES.NO_CREDENTIALS);
})


