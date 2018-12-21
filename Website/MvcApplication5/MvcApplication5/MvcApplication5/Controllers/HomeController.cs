using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using MvcApplication5.Models;

namespace MvcApplication5.Controllers
{
    public class HomeController : Controller
    {
        //
        // GET: /Home/
        DataClasses1DataContext dc = new DataClasses1DataContext();

        public ActionResult Index()
        {
            return View(dc.Movies.ToList());
        }
        public ActionResult Home()
        {
            return View(dc.Movies.ToList());
        }
        public ActionResult Signin()
        {
            return View();
        }
        [HttpPost]
        public ActionResult SigninCheck()
        {
            string email=Request["email"];
            string pass = Request["password"];
            int num = 0;
            foreach (var user in dc.Users.ToList())
            {
                if (user.Email.Equals(email) && user.Pass.Equals(pass))
                {
                    num = 1;
                }
            }
            if(num==1)
            return RedirectToAction("Admin");
            else
            return RedirectToAction("Signin");
        }
        public ActionResult Admin()
        {
            return View(dc.Users.ToList());
        }
        public ActionResult AddUser()
        {
            return View();
        }
        [HttpPost]
        public ActionResult AddUserr()
        {
            string uName = Request["uName"];
            string uEmail = Request["uEmail"];
            string uPass = Request["uPass"];

            foreach (User u in dc.Users)
            {
                if (u.Email.ToString().Equals(uEmail.ToString()))
                    return RedirectToAction("Admin");
            }

            User s = new User();
            s.Name = uName;
            s.Pass = uPass;
            s.Email = uEmail;

            dc.Users.InsertOnSubmit(s);
            dc.SubmitChanges();
            return RedirectToAction("Admin");
        }
        public ActionResult Movie(int id)
        {
            Movy res = dc.Movies.First(x => x.Id == id);
            return View(res);
        }
        public ActionResult UpdateUser(int id)
        {
            User res = dc.Users.First(x => x.Id == id);
            return View(res);
        }
        public ActionResult DeleteUser(int id)
        {
            User res = dc.Users.First(x => x.Id == id);
          

            dc.Users.DeleteOnSubmit(res);
            dc.SubmitChanges();
            return RedirectToAction("Admin");
        }
        [HttpPost]
        public ActionResult UpdateConfirm()
        {
            User us = new User();
            us.Id = int.Parse(Request["uId"]);
            us.Name = Request["uName"];
            us.Pass = Request["uPass"];
            us.Email = Request["uEmail"];

            //System.Console.WriteLine(us.Id);
           var s = dc.Users.First(x => x.Id == us.Id);

            s.Name = us.Name;
            s.Pass = us.Pass;
            s.Email = us.Email;

            dc.SubmitChanges();
            return RedirectToAction("Admin");
        }
        public ActionResult Logout()
        {
            return RedirectToAction("Signin");
        }
        public ActionResult addmovie()
        {
            return View("addmovie");
        }
        [HttpPost]
        public ActionResult addMoviee()
        {
            string name = Request["name"];
            string year = Request["year"];
            string picture = Request["picture"];
            string language = Request["language"];
            string cast = Request["cast"];
            string rating = Request["rating"];
            string review = Request["review"];
            string trailer = Request["trailer"];
            Movy s = new Movy();
            s.name = name;
            s.picture = picture;
            s.year = year;
            s.language = language;
            s.cast = cast;
            s.rating = rating;
            s.trailer = trailer;
            s.review = review;
            dc.Movies.InsertOnSubmit(s);
            dc.SubmitChanges();
            return RedirectToAction("addmovie");
        
        }
        public ActionResult ViewMovie()
        {

            return View(dc.Movies.ToList());
        
        }
        public ActionResult DeleteMovie(int id)
        {
            Movy res = dc.Movies.First(x => x.Id == id);


            dc.Movies.DeleteOnSubmit(res);
            dc.SubmitChanges();
            return RedirectToAction("ViewMovie");
        }
        public ActionResult UpdateMovie(int id)
        {
            Movy res = dc.Movies.First(x => x.Id == id);
            return View(res);
        }
        [HttpPost]
        public ActionResult UpdateMoviee()
        {
            int Id = int.Parse(Request["Id"]);
            string name = Request["name"];
            string year = Request["year"];
            string picture = Request["picture"];
            string language = Request["language"];
            string cast = Request["cast"];
            string rating = Request["rating"];
            string review = Request["review"];
            string trailer = Request["trailer"];
            Movy s = new Movy();
            s.Id = Id;
            s.name = name;
            s.picture = picture;
            s.year = year;
            s.language = language;
            s.cast = cast;
            s.rating = rating;
            s.trailer = trailer;
            s.review = review;

            //System.Console.WriteLine(us.Id);
            var ss = dc.Movies.First(x => x.Id == s.Id);

            ss.name = s.name;
            ss.picture = s.picture;
            ss.year = s.year;
            ss.language = s.language;
            ss.cast = s.cast;
            ss.rating = s.rating;
            ss.trailer = s.trailer;
            ss.review = s.review;
           

            dc.SubmitChanges();
            return RedirectToAction("ViewMovie");
        }

        public ActionResult Bollywood()
        {

            return View(dc.Movies.ToList());

        }
        public ActionResult Hollywood()
        {

            return View(dc.Movies.ToList());

        }
        public ActionResult Animated()
        {

            return View(dc.Movies.ToList());

        }
        public ActionResult Pakistani()
        {

            return View(dc.Movies.ToList());

        }
        [HttpPost]
        public ActionResult Search()
        {
            string toSearch = Request["tosearch"];
            ViewBag.toS = toSearch;
            return View(dc.Movies.ToList());
        }
    }
}
