'use strict'

describe('My First Test', () => {
	
	
	beforeEach( () => {
    cy.visit('/login')
  	})

	it('Debe fallar el inicio de sesion', ()=>{
		//cy.visit('/login')
		cy.get('#username').type('Isabel')
		cy.get('#password').type('Isa123')
		cy.contains('.btn', 'Submit').click()
		cy.get('.alert').should('be.visible')
	})

	it('Debe hacer inicio de sesion', ()=>{
		//cy.visit('/login')
		cy.get('#username').type('Isabel Murillo')
		cy.get('#password').type('Isa123')
		cy.contains('.btn', 'Submit').click()
		cy.get('.alert').should('not.exist')
	})

	it('Crear una institución', ()=>{
		//cy.visit('/login')
		cy.get('#username').type('Natalia Isabel')
		cy.get('#password').type('Nat123')
		cy.contains('.btn', 'Submit').click()
		cy.get('.alert').should('not.exist')
		cy.get(':nth-child(2) > :nth-child(1) > p > a').click()
		cy.get('p.my-5 > .btn').click()
		cy.get('#instName').type('Universidad Santiago de Cali')
		cy.get('#instAcademicserverurl').type('https://www.usc.edu.co/')
		cy.get('#instAcadextradataurl').type('https://www.usc.edu.co/')
		cy.get('#instAcadpersoninfodocurl').type('https://www.usc.edu.co/')
		cy.get('#instAcadloginurl').type('https://www.usc.edu.co/')
		cy.get('#instAcadpersoninfoidurl').type('https://www.usc.edu.co/')
		cy.get('#instAcadphysicalspacesurl').type('https://www.usc.edu.co/')
		cy.get('#instAcadprogrammedcoursesurl').type('https://www.usc.edu.co/')
		cy.get('#instLdapurl').type('https://www.usc.edu.co/')
		cy.get('#instAcadloginusername').type('usc')
		cy.get('#instAcadloginpassword').type('usc123')
		cy.get('#instLdapbasedn').type('usc')
		cy.get('#instLdappassword').type('usc')
		cy.get('#instLdapusersearchbase').type('usc')
		cy.get('#instLdapusersearchfilter').type('usc')
		cy.get('.col-md-4 > .btn').click()
		cy.get('.alert').should('not.exist')
		
	})
	
	it('Debe agregar una persona, luego mostrarla, editarla y al final eliminarla', ()=>{
		cy.visit('/login')
		cy.get('#username').type('Isabel Murillo')
		cy.get('#password').type('Isa123')
		cy.contains('.btn', 'Submit').click()
		cy.get('.alert').should('not.exist')
		cy.get(':nth-child(2) > :nth-child(1) > p > a').click()
		cy.get('p.my-5 > .btn').click()
		cy.get('#persName').type('Miguel')
		cy.get('#persLastname').type('Gonzalez')
		cy.get('#persIddocument').type('1205489756')
		cy.get('#persIsactive').select('Y')
		cy.get('#persAddress').type('Carrera 76 # 2a - 110')
		cy.get('#persContactnumber').type('3167121276')
		cy.get('#persEmail').type('miguel@gmail.com')
		cy.get('#instid').select("Universidad Icesi")//cambiaaar
		cy.get('#persLatitude').type('325698741')
		cy.get('#persLongitude').type('-6589742135')
		cy.get("#persOnsetdate").type('2022-02-02');
		cy.get("#persPoliticsaccepteddate").type('2022-02-02');
		cy.get('#persPoliticsaccepted').type('N/A')
		cy.contains('.btn', 'Add Person').click()
		cy.contains('.tbody', 'Miguel')
		// show
		cy.get(':nth-child(3) > :nth-child(9) > .btn').click()
		//edit
		cy.contains('.btn', 'Edit').click()
		cy.get('#persLastname').type(' Murillo')
		cy.contains('.btn', 'Update Person').click()
		cy.contains('.btn', 'Go Persons').click()
		//edit2
		cy.get(':nth-child(3) > :nth-child(10) > .btn > .fas').click()
		cy.get('#persName').type(' Alberto')
		cy.contains('.btn', 'Update Person').click()
		cy.contains('.btn', 'Go Persons').click()
		// Delete
		cy.get(':nth-child(3) > :nth-child(11) > .btn').click()
		cy.wait(2000)
	})
	

	
	
})
