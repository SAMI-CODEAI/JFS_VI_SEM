const inventors = {
  guido: {
    name: "Guido van Rossum",
    desc: "Inventor of Python, known for emphasizing readability and simplicity in programming languages.",
    img: "images/guido.jpeg",
    usage: "Python is widely used in web development, data science, machine learning, AI, automation, and scripting because of its simplicity and huge ecosystem of libraries."
  },
  gosling: {
    name: "James Gosling",
    desc: "Inventor of Java, designed with portability and reliability in mind.",
    img: "images/gosling.jpg",
    usage: "Java powers Android apps, enterprise systems, banking software, and large-scale web applications. Its portability (runs on JVM) and security make it a backbone of mission-critical systems."
  },
  ritchie: {
    name: "Dennis Ritchie",
    desc: "Inventor of C, which laid the foundation for modern operating systems and languages.",
    img: "images/ritchie.jpeg",
    usage: "C is used for operating systems (like UNIX/Linux), embedded systems, compilers, and performance-critical applications. It’s valued for speed and direct hardware interaction."
  },
  stroustrup: {
    name: "Bjarne Stroustrup",
    desc: "Inventor of C++, combining efficiency of C with object-oriented features.",
    img: "images/stroustrup.jpeg",
    usage: "C++ is used in game engines, real-time simulations, operating systems, browsers, and high-performance applications. It balances low-level control with object-oriented design."
  },
  matsumoto: {
    name: "Yukihiro Matsumoto",
    desc: "Inventor of Ruby, designed for programmer happiness and productivity.",
    img: "images/matsumoto.jpeg",
    usage: "Ruby is popular for web development via Ruby on Rails, powering platforms like GitHub and Shopify. It’s also used for automation, DevOps scripting, and rapid prototyping."
  },
  wall: {
    name: "Larry Wall",
    desc: "Inventor of Perl, known for its text-processing power.",
    img: "images/wall.jpeg",
    usage: "Perl excels at text manipulation, system administration, bioinformatics, and legacy web applications. It’s often called the 'duct tape of the Internet' for its versatility."
  },
  bergstrom: {
    name: "Andreas Bergstrom",
    desc: "Contributor to Go language development.",
    img: "images/bergstrom.jpeg",
    usage: "Go (Golang) is used for cloud services, microservices, networking, and large-scale web apps. Its concurrency model and speed make it ideal for modern distributed systems."
  },
  eich: {
    name: "Brendan Eich",
    desc: "Inventor of JavaScript, enabling interactive web applications.",
    img: "images/eich.jpeg",
    usage: "JavaScript is the backbone of web development, enabling interactivity in browsers. It’s also used in server-side apps (Node.js), mobile apps, games, and desktop apps (Electron)."
  },
  griesemer: {
    name: "Robert Griesemer",
    desc: "Co-creator of Go, focusing on simplicity and efficiency.",
    img: "images/griesemer.jpeg",
    usage: "Go is chosen for scalable backend systems, APIs, and cloud-native applications due to its simplicity, concurrency support, and fast compilation."
  },
  odersky: {
    name: "Martin Odersky",
    desc: "Inventor of Scala, blending object-oriented and functional programming.",
    img: "images/odersky.jpeg",
    usage: "Scala is used in big data (Apache Spark), enterprise apps, and functional programming projects. It runs on the JVM and is favored by companies like LinkedIn and Netflix."
  }
};

const select = document.getElementById("inventor-select");
const img = document.getElementById("inventor-img");
const name = document.getElementById("inventor-name");
const desc = document.getElementById("inventor-desc");
const usage = document.getElementById("inventor-usage");

select.addEventListener("change", function() {
  const selected = inventors[this.value];
  if (selected) {
    img.src = selected.img;
    name.textContent = selected.name;
    desc.textContent = selected.desc;
    usage.textContent = selected.usage;
  }
});

// Initialize with first inventor
select.dispatchEvent(new Event("change"));