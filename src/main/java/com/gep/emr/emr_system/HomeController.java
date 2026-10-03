package com.gep.emr.emr_system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>VisionCare EMR - Front Desk & Patient Registration</title>
                <!-- Google Fonts: Inter -->
                <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
                <!-- Tailwind CSS CDN -->
                <script src="https://cdn.tailwindcss.com"></script>
                <script>
                  tailwind.config = {
                    theme: {
                      extend: {
                        fontFamily: {
                          sans: ['Inter', 'sans-serif'],
                        }
                      }
                    }
                  }
                </script>
                <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
            </head>
            <body class="bg-slate-50 text-slate-800 font-sans antialiased" x-data="{ currentView: 'schedule', showModal: false, selectedPatient: 'Jane Doe' }">

                <!-- Top Navigation Header -->
                <header class="bg-blue-900 text-white shadow-lg sticky top-0 z-40">
                    <div class="max-w-7xl mx-auto px-6 py-3.5 flex justify-between items-center">
                        <div class="flex items-center space-x-3">
                            <span class="text-xl font-bold tracking-tight">VisionCare EMR</span>
                            <span class="text-xs bg-blue-800/80 text-blue-100 px-3 py-1 rounded-full font-medium border border-blue-700/50">Sprint 1: Front Desk</span>
                        </div>
                        <div class="flex space-x-2">
                            <button @click="currentView = 'schedule'" :class="currentView === 'schedule' ? 'bg-blue-700 shadow-sm' : 'hover:bg-blue-800/60'" class="px-4 py-2 rounded-lg text-sm font-medium transition">
                                Schedule & Queue
                            </button>
                            <button @click="currentView = 'demographics'" :class="currentView === 'demographics' ? 'bg-blue-700 shadow-sm' : 'hover:bg-blue-800/60'" class="px-4 py-2 rounded-lg text-sm font-medium transition">
                                Patient Demographics
                            </button>
                        </div>
                    </div>
                </header>

                <!-- Main Container -->
                <main class="max-w-7xl mx-auto px-6 py-8">

                    <!-- VIEW 1: SCHEDULE & CHECK-IN QUEUE -->
                    <div x-show="currentView === 'schedule'" class="space-y-6">
                        <div class="flex justify-between items-center bg-white p-5 rounded-2xl shadow-sm border border-slate-200/80">
                            <div>
                                <h1 class="text-2xl font-bold text-slate-900 tracking-tight">Today's Clinic Schedule</h1>
                                <p class="text-sm text-slate-500 mt-0.5">Manage patient arrivals, walk-ins, and intake queues efficiently.</p>
                            </div>
                            <button @click="showModal = true" class="bg-blue-600 hover:bg-blue-700 text-white px-4.5 py-2.5 rounded-xl text-sm font-semibold shadow-sm transition flex items-center space-x-2">
                                <span>+ Register New / Walk-In Patient</span>
                            </button>
                        </div>

                        <!-- Queue Table -->
                        <div class="bg-white rounded-2xl shadow-sm border border-slate-200/80 overflow-hidden">
                            <table class="w-full text-left border-collapse">
                                <thead>
                                    <tr class="bg-slate-50/70 text-slate-500 text-xs uppercase tracking-wider font-semibold border-b border-slate-200">
                                        <th class="p-4.5">Time</th>
                                        <th class="p-4.5">Patient Name</th>
                                        <th class="p-4.5">MRN</th>
                                        <th class="p-4.5">Visit Type</th>
                                        <th class="p-4.5">Status</th>
                                        <th class="p-4.5 text-right">Actions</th>
                                    </tr>
                                </thead>
                                <tbody class="divide-y divide-slate-100 text-sm">
                                    <tr class="hover:bg-slate-50/50 transition">
                                        <td class="p-4.5 font-semibold text-slate-900">09:00 AM</td>
                                        <td class="p-4.5">
                                            <span class="font-semibold text-blue-600 cursor-pointer hover:underline" @click="currentView = 'demographics'; selectedPatient = 'Jane Doe';">Jane Doe</span>
                                        </td>
                                        <td class="p-4.5 text-slate-500 font-mono text-xs">MRN-10492</td>
                                        <td class="p-4.5 text-slate-700">Comprehensive Exam</td>
                                        <td class="p-4.5"><span class="bg-emerald-50 text-emerald-700 border border-emerald-200/60 text-xs px-3 py-1 rounded-full font-medium">Checked In</span></td>
                                        <td class="p-4.5 text-right">
                                            <button @click="currentView = 'demographics'; selectedPatient = 'Jane Doe';" class="text-blue-600 hover:text-blue-800 text-xs font-semibold">Open Chart</button>
                                        </td>
                                    </tr>
                                    <tr class="hover:bg-slate-50/50 transition">
                                        <td class="p-4.5 font-semibold text-slate-900">09:30 AM</td>
                                        <td class="p-4.5"><span class="font-semibold text-blue-600 cursor-pointer hover:underline" @click="currentView = 'demographics'; selectedPatient = 'Robert Smith';">Robert Smith</span></td>
                                        <td class="p-4.5 text-slate-500 font-mono text-xs">MRN-10493</td>
                                        <td class="p-4.5 text-slate-700">ROP Screening</td>
                                        <td class="p-4.5"><span class="bg-amber-50 text-amber-700 border border-amber-200/60 text-xs px-3 py-1 rounded-full font-medium">Waiting Room</span></td>
                                        <td class="p-4.5 text-right">
                                            <button @click="currentView = 'demographics'; selectedPatient = 'Robert Smith';" class="text-blue-600 hover:text-blue-800 text-xs font-semibold">Open Chart</button>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <!-- VIEW 2: PATIENT DEMOGRAPHICS FORM -->
                    <div x-show="currentView === 'demographics'" class="space-y-6">
                        <div class="bg-white p-5 rounded-2xl shadow-sm border border-slate-200/80 flex justify-between items-center">
                            <div>
                                <h1 class="text-2xl font-bold text-slate-900 tracking-tight">Patient Chart: <span class="text-blue-600" x-text="selectedPatient"></span></h1>
                                <p class="text-sm text-slate-500 mt-0.5">Initial demographics, identification, and emergency contact details.</p>
                            </div>
                            <span class="bg-blue-50 text-blue-700 border border-blue-200/60 text-xs font-semibold px-3.5 py-1.5 rounded-xl font-mono">Active MRN: MRN-10492</span>
                        </div>

                        <!-- Demographics Form Layout -->
                        <div class="bg-white p-6 rounded-2xl shadow-sm border border-slate-200/80 grid grid-cols-1 md:grid-cols-3 gap-6">
                            <!-- Personal Info -->
                            <div class="space-y-4 md:col-span-2">
                                <h3 class="text-sm font-bold text-slate-900 uppercase tracking-wider border-b border-slate-100 pb-2">1. Personal Information</h3>
                                <div class="grid grid-cols-2 gap-4">
                                    <div>
                                        <label class="block text-xs font-semibold text-slate-600 uppercase mb-1.5">First Name</label>
                                        <input type="text" value="Jane" class="w-full border border-slate-300/80 rounded-xl p-2.5 text-sm focus:ring-2 focus:ring-blue-500/20 focus:border-blue-600 outline-none transition">
                                    </div>
                                    <div>
                                        <label class="block text-xs font-semibold text-slate-600 uppercase mb-1.5">Last Name</label>
                                        <input type="text" value="Doe" class="w-full border border-slate-300/80 rounded-xl p-2.5 text-sm focus:ring-2 focus:ring-blue-500/20 focus:border-blue-600 outline-none transition">
                                    </div>
                                    <div>
                                        <label class="block text-xs font-semibold text-slate-600 uppercase mb-1.5">Date of Birth</label>
                                        <input type="date" value="1988-05-14" class="w-full border border-slate-300/80 rounded-xl p-2.5 text-sm focus:ring-2 focus:ring-blue-500/20 focus:border-blue-600 outline-none transition">
                                    </div>
                                    <div>
                                        <label class="block text-xs font-semibold text-slate-600 uppercase mb-1.5">Gender</label>
                                        <select class="w-full border border-slate-300/80 rounded-xl p-2.5 text-sm bg-white focus:ring-2 focus:ring-blue-500/20 focus:border-blue-600 outline-none transition">
                                            <option selected>Female</option>
                                            <option>Male</option>
                                            <option>Other</option>
                                        </select>
                                    </div>
                                </div>

                                <h3 class="text-sm font-bold text-slate-900 uppercase tracking-wider border-b border-slate-100 pb-2 pt-4">2. Contact & Insurance</h3>
                                <div class="grid grid-cols-2 gap-4">
                                    <div>
                                        <label class="block text-xs font-semibold text-slate-600 uppercase mb-1.5">Phone Number</label>
                                        <input type="text" value="(555) 234-5678" class="w-full border border-slate-300/80 rounded-xl p-2.5 text-sm focus:ring-2 focus:ring-blue-500/20 focus:border-blue-600 outline-none transition">
                                    </div>
                                    <div>
                                        <label class="block text-xs font-semibold text-slate-600 uppercase mb-1.5">Email Address</label>
                                        <input type="email" value="jane.doe@example.com" class="w-full border border-slate-300/80 rounded-xl p-2.5 text-sm focus:ring-2 focus:ring-blue-500/20 focus:border-blue-600 outline-none transition">
                                    </div>
                                </div>
                            </div>

                            <!-- Sidebar Summary & Emergency Contact -->
                            <div class="space-y-4 bg-slate-50/70 p-5 rounded-2xl border border-slate-200/80">
                                <h3 class="text-sm font-bold text-slate-900 uppercase tracking-wider border-b border-slate-200 pb-2">Emergency Contact</h3>
                                <div>
                                    <label class="block text-xs font-semibold text-slate-600 uppercase mb-1.5">Contact Name</label>
                                    <input type="text" value="John Doe (Spouse)" class="w-full border border-slate-300/80 rounded-xl p-2.5 text-sm bg-white">
                                </div>
                                <div>
                                    <label class="block text-xs font-semibold text-slate-600 uppercase mb-1.5">Contact Phone</label>
                                    <input type="text" value="(555) 987-6543" class="w-full border border-slate-300/80 rounded-xl p-2.5 text-sm bg-white">
                                </div>
                                <div class="pt-4">
                                    <button class="w-full bg-emerald-600 hover:bg-emerald-700 text-white font-semibold py-2.5 rounded-xl shadow-sm text-sm transition">
                                        Save & Proceed to Exam
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- MODAL: REGISTER WALK-IN -->
                    <div x-show="showModal" class="fixed inset-0 bg-slate-900/60 backdrop-blur-sm flex items-center justify-center p-4 z-50" style="display: none;">
                        <div class="bg-white rounded-2xl max-w-lg w-full p-6 shadow-2xl space-y-4 border border-slate-100">
                            <div class="flex justify-between items-center border-b border-slate-100 pb-3">
                                <h3 class="text-lg font-bold text-slate-900">Register New / Walk-In Patient</h3>
                                <button @click="showModal = false" class="text-slate-400 hover:text-slate-600 font-bold text-xl">&times;</button>
                            </div>
                            <div class="space-y-3.5 text-sm">
                                <div>
                                    <label class="block font-semibold text-slate-700 mb-1">Full Legal Name</label>
                                    <input type="text" placeholder="e.g. John Smith" class="w-full border border-slate-300 rounded-xl p-2.5 focus:ring-2 focus:ring-blue-500/20 outline-none">
                                </div>
                                <div class="grid grid-cols-2 gap-3">
                                    <div>
                                        <label class="block font-semibold text-slate-700 mb-1">Date of Birth</label>
                                        <input type="date" class="w-full border border-slate-300 rounded-xl p-2.5">
                                    </div>
                                    <div>
                                        <label class="block font-semibold text-slate-700 mb-1">Phone Number</label>
                                        <input type="text" placeholder="(555) 000-0000" class="w-full border border-slate-300 rounded-xl p-2.5">
                                    </div>
                                </div>
                                <div class="grid grid-cols-2 gap-3">
                                    <div>
                                        <label class="block font-semibold text-slate-700 mb-1">Arrival Time</label>
                                        <input type="time" value="11:00" class="w-full border border-slate-300 rounded-xl p-2.5 font-medium text-slate-800">
                                    </div>
                                    <div>
                                        <label class="block font-semibold text-slate-700 mb-1">Priority Status</label>
                                        <select class="w-full border border-slate-300 rounded-xl p-2.5 text-slate-800 font-medium">
                                            <option class="text-red-600 font-bold">Emergency / Urgent</option>
                                            <option>Walk-In (Standard)</option>
                                            <option>Scheduled Appointment</option>
                                        </select>
                                    </div>
                                </div>
                                <div>
                                    <label class="block font-semibold text-slate-700 mb-1">Chief Complaint / Visit Reason</label>
                                    <input type="text" placeholder="e.g. Acute eye pain, blurry vision" class="w-full border border-slate-300 rounded-xl p-2.5">
                                </div>
                            </div>
                            <div class="flex justify-end space-x-3 pt-4 border-t border-slate-100">
                                <button @click="showModal = false" class="px-4 py-2 border border-slate-300 rounded-xl text-slate-600 hover:bg-slate-50 text-sm font-semibold transition">Cancel</button>
                                <button @click="showModal = false" class="px-4 py-2 bg-blue-600 hover:bg-blue-700 text-white rounded-xl text-sm font-semibold shadow-sm transition">Add to Queue</button>
                            </div>
                        </div>
                    </div>

                </main>

            </body>
            </html>
            """;
    }
}