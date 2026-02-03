import { Selector, t } from 'testcafe';

class LoginPage {
    constructor() {
        this.userInput = Selector('#user-name');
        this.passInput = Selector('#password');
        this.loginBtn  = Selector('#login-button');
        this.errorMessage = Selector('h3[data-test="error"]');
    }

    async clickLogin() {
    await t.click(this.loginBtn);
}

    async login(user, pass) {
        await t
            .typeText(this.userInput, user)
            .typeText(this.passInput, pass)
            .click(this.loginBtn);
    }
}

export default new LoginPage(); 