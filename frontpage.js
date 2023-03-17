const form = document.querySelector('.form');
form.addEventListener('submit', (event) => {
  event.preventDefault();
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;
  const role = document.querySelector('input[name="option"]:checked').value;
  console.log(`User ${username} with role ${role} has submitted the login form.`);

  // Check the user's password and username based on their role
  let correctPassword = '';
  let correctUsername = '';
  switch (role) {
    case 'option1': // Admin
      correctUsername = 'admin';
      correctPassword = 'admin123';
      break;
    case 'option2': // Quantity Surveyor
      correctUsername = 'surveyor';
      correctPassword = 'surveyor123';
      break;
    case 'option3': // Supplier
      correctUsername = 'supplier';
      correctPassword = 'supplier123';
      break;
    case 'option4': // Client
      correctUsername = 'client';
      correctPassword = 'client123';
      break;
    default:
      console.log('Error: Invalid user role');
  }

  // Redirect the user to a new page if the password and username are correct
  if (username === correctUsername && password === correctPassword) {
    switch (role) {
      case 'option1': // Admin
        window.location.href = 'admin.html';
        break;
      case 'option2': // Quantity Surveyor
        window.location.href = 'surveyor.html';
        break;
      case 'option3': // Supplier
        window.location.href = 'supplier.html';
        break;
      case 'option4': // Client
        window.location.href = 'clientview.html';
        break;
      default:
        console.log('Error: Invalid user role');
    }
  } else {
    alert('Incorrect username or password. Please try again.');
  }
});




